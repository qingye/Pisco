package com.chris.pisco.model;

import com.chris.pisco.model.processer.BitmapProcessor;

/**
 * Created by chris on 2018/2/8.
 */

public class Options {

    private BitmapProcessor processor;

    public Options(BitmapProcessor processor) {
        this.processor = processor;
    }

    public BitmapProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(BitmapProcessor processor) {
        this.processor = processor;
    }
}
