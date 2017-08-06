package apps.savvisingh.docsapptestapp.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
