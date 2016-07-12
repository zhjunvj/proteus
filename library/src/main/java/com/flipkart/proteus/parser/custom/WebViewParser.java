package com.flipkart.proteus.parser.custom;

import com.flipkart.proteus.parser.Attributes;
import com.flipkart.proteus.parser.Parser;
import com.flipkart.proteus.parser.WrappableParser;
import com.flipkart.proteus.processor.StringAttributeProcessor;
import com.flipkart.proteus.view.WebView;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class WebViewParser<T extends WebView> extends WrappableParser<T> {
    public WebViewParser(Parser<T> wrappedParser) {
        super(android.webkit.WebView.class, wrappedParser);
    }

    @Override
    protected void prepareHandlers() {
        super.prepareHandlers();
        addHandler(Attributes.WebView.Url, new StringAttributeProcessor<T>() {
            @Override
            public void handle(String attributeKey, String attributeValue, T view) {
                view.loadUrl(attributeValue);
            }
        });
        addHandler(Attributes.WebView.HTML, new StringAttributeProcessor<T>() {
            @Override
            public void handle(String attributeKey, String attributeValue, T view) {
                view.loadData(attributeValue, "text/html", "UTF-8");
            }
        });
    }
}