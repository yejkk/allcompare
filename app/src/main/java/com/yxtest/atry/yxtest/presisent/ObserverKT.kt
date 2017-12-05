package com.yxtest.atry.yxtest.presisent

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


/**
 * Created by userd on 2017/12/5.
 */

class ObserverKT<T> : Observer<T> {

    override fun onSubscribe(s: Disposable) {
        //这一步是必须，我们通常可以在这里做一些初始化操作，调用request()方法表示初始化工作已经完成
        //调用request()方法，会立即触发onNext()方法
        //在onComplete()方法完成，才会再执行request()后边的代码

    }

    override fun onNext(value: T) {
        Log.e("onNext", value.toString())
    }

    override fun onError(t: Throwable) {
        Log.e("onError", t.message)
    }

    override fun onComplete() {
        //由于Reactive-Streams的兼容性，方法onCompleted被重命名为onComplete
        Log.e("onComplete", "complete")
    }

}