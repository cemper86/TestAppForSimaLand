package ru.stairenx.testappforsimaland.view_model;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class ActionLiveData<T> extends MutableLiveData<T> {

    @Override
    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {

        if (hasObservers()) {
            try {
                throw new Throwable("Only one observer at a time may subscribe to a ActionLiveData");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        super.observe(owner, data -> {
            if (data == null) {
                return;
            }
            observer.onChanged(data);
            postValue(null);
        });
    }

    @MainThread
    public void sendAction(T data) {
        postValue(data);
    }
}