package apps.savvisingh.docsapptestapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import apps.savvisingh.docsapptestapp.R;
import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.message)
    EditText message;

    @BindView(R.id.btn_send)
    Button button;

    RecyclerView.Adapter mAdapter;

    ArrayList<Message> messageArrayList;

    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new MainPresenter<>();
        mPresenter.onAttach(this);

        messageArrayList = new ArrayList<>();
        mAdapter = new ChatAdapter(messageArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mPresenter.getChatHistory();

    }

    @OnClick(R.id.btn_send)
    void sendMessageButtonClick(){
        String text = message.getText().toString();
        mPresenter.sendMessage(text);
        message.setText("");
    }

    @Override
    public void displayMessage(Message message) {
        messageArrayList.add(message);
        mAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(mAdapter.getItemCount()-1);
    }

    @Override
    public void loadChatHistory(List<Message> mList) {
        if(mList!=null && mList.size()>0){
            messageArrayList.addAll(mList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
