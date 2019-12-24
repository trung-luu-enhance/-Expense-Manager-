package com.trunghtluu.projectw3we.presenter;

import java.util.List;

public interface Contract {

    interface Presenter {
        void insert();
        List load();
    }

    interface BaseView {

    }

    interface ViewMain extends BaseView {
        void display();
    }

    interface ViewAdd extends BaseView {
        void insert();
    }

    interface ViewEdit extends BaseView {
        void update();
    }
}
