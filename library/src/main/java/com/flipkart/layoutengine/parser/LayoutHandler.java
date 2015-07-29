package com.flipkart.layoutengine.parser;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.flipkart.layoutengine.ParserContext;
import com.flipkart.layoutengine.view.ProteusView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * @author kiran.kumar
 */
public interface LayoutHandler<V extends View> {

    V createView(ParserContext parserContext, Context context, ViewGroup parent, JsonObject object);

    boolean handleAttribute(ParserContext context, String attribute, JsonElement element,
                            JsonObject layout, ProteusView view, int childIndex);


    JsonArray parseChildren(ParserContext context, JsonElement element, int childIndex);

    boolean canAddChild();

    void setupView(ParserContext context, ViewGroup parent, V view, JsonObject layout);

    void prepare(Context context);

    void addChildren(ParserContext parserContext, ProteusView parent, List<ProteusView> children, JsonObject viewLayout);
}
