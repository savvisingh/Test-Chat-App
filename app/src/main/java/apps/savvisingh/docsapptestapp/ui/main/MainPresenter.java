package apps.savvisingh.docsapptestapp.ui.main;

import android.content.Context;
import android.util.Log;

import java.sql.Timestamp;
import java.util.List;

import apps.savvisingh.docsapptestapp.data.AppDataManager;
import apps.savvisingh.docsapptestapp.data.DataManager;
import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class MainPresenter<V extends MainMvpView> implements MainMvpPresenter<V>{

    private MainMvpView mvpView;

    private DataManager mDataManager;

    private CompositeDisposable mCompositeDisposable;

    public MainPresenter(){
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
        mDataManager = new AppDataManager((Context) mvpView);
    }

    @Override
    public void onDetach() {
        if(mCompositeDisposable != null && !mCompositeDisposable.isDisposed())
            mCompositeDisposable.dispose();
        this.mvpView = null;
    }

    @Override
    public void sendMessage(String message) {

        if(!message.isEmpty()){

            mvpView.hideKeyboard();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Message msg = new Message(message, timestamp.toString(), "self");
            mCompositeDisposable.add(mDataManager.insertMessage(msg)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> Log.d("Success", "Record Inserted"), this::error));

            mvpView.displayMessage(msg);

            mCompositeDisposable.add(mDataManager.sendMessage(message)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::success, this::error)
            );

        }

    }

    @Override
    public void getChatHistory() {
        mCompositeDisposable.add(mDataManager.getChatHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::loadData, this::error)
        );

    }

    private void loadData(List<Message> messages) {
        mvpView.loadChatHistory(messages);
    }

    private void error(Throwable throwable) {
        Log.e("Error", throwable.getMessage());
        mvpView.onError(throwable.getLocalizedMessage());
    }

    private void success(ChatApiResponse chatApiResponse) {

        if(chatApiResponse.getSuccess() == 1){
            String msg = chatApiResponse.getMessage().getMessage();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Log.d("Message reply", msg);
            Message message = new Message(msg, timestamp.toString(), "other");
            mCompositeDisposable.add(mDataManager.insertMessage(message)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> Log.d("Success", "Record Inserted"), this::error));
            mvpView.displayMessage(message);

        }else {
            mvpView.onError(chatApiResponse.getErrorMessage());
        }
    }
}
