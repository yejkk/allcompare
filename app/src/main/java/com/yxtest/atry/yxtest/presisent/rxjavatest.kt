package com.yxtest.atry.yxtest.presisent

import android.util.Log
import io.reactivex.*
import io.reactivex.disposables.Disposable

/**
 * Created by userd on 2017/11/28.
 */

class rxjavatest{

    final val TAG = "rxjavatest"

    fun rxtest(){
        //创建一个上游 Observable：
        val observable = Observable.create( ObservableOnSubscribe<Int>() {

            fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })

        //创建一个下游 Observer
        val observer = ObserverKT<Int>()

        observable.subscribe(observer)



        Flowable.create(FlowableOnSubscribe<String>(){
            override fun subscribe(emitter:FlowableEmitter<String>) {
                emitter.onNext("Hello,I am China!")
            }
        }, BackpressureStrategy.BUFFER)
        .subscribe(subscriber);

    }
//    //创建一个上游 Observable：
//    Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//        @Override
//        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//            emitter.onNext(1);
//            emitter.onNext(2);
//            emitter.onNext(3);
//            emitter.onComplete();
//        }
//    });
//    //创建一个下游 Observer
//    Observer<Integer> observer = new Observer<Integer>() {
//        @Override
//        public void onSubscribe(Disposable d) {
//            Log.d(TAG, "subscribe");
//        }
//
//        @Override
//        public void onNext(Integer value) {
//            Log.d(TAG, "" + value);
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            Log.d(TAG, "error");
//        }
//
//        @Override
//        public void onComplete() {
//            Log.d(TAG, "complete");
//        }
//    };
//    //建立连接
//    observable.subscribe(observer);
}

