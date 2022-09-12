package com.example.facebookv2.ui.main;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2.data.PostsClient;
import com.example.facebookv2.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";

    MutableLiveData<List<PostModel>>  postsMutableLiveData = new MutableLiveData<>();

    CompositeDisposable disposable = new CompositeDisposable();

    public void getPosts(){
        Single<List<PostModel>> observable = PostsClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());



        disposable.add(observable.subscribe(c->postsMutableLiveData.setValue(c), e-> Log.d(TAG, "getPosts: "+e)));
    }


}
