package com.pfe.crm.core.web;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.ndg.core.util.StringUtilities;

/**
 * RequestParameterMap<br>
 * 
 * A wrapper around the HttpServletRequest allowing easy access to parameters.<br>
 * 
 * Copyright (c) Straightline 2003. All Rights Reserved.
 * 
 * @author Ben Northrop - October 13th, 2003
 */
public class RequestParameterMap extends HashMap implements Serializable
{
    /**
     * Determines if a de-serialized file is compatible with this class.
     */
    private static final long serialVersionUID = 1L;

    // CONSTRUCTORS
    /**
     * Private default constructor.
     */
    private RequestParameterMap()
    {
    }

    /**
     * Default constructor. Ensures that a HttpRequest is passed in.
     */
    public static RequestParameterMap getInstance(HttpServletRequest request)
    {
        RequestParameterMap parameters = new RequestParameterMap();

        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = (String) parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            parameters.put(parameterName, parameterValue);
        }

        return parameters;
    }

    // METHODS
    /**
     * Get a String, given the input key.
     */
    public String getString(String key) throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            throw new WebRequestException("value is empty: " + key, null);
        }

        return value;
    }

    /**
     * Get a String, given the input key, if it's empty, then return the
     * default.
     */
    public String getString(String key, String defaultValue)
            throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            return defaultValue;
        }

        return value;
    }

    /**
     * Get an int, given the key.
     * 
     * @throws ReportException
     *             if there is a NumberFormatException or value is null.
     */
    public float getFloat(String key) throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (value == null) {
            throw new WebRequestException(
                    "value is null for key: " + key + "!", null);
        }

        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException nfe) {
            throw new WebRequestException("Couldn't convert float: " + key
                    + " to float.", nfe);
        }
    }

    /**
     * An overloaded method of the getInt above. Passes in the int value that
     * will be used as default if the key does not exist.
     */
    public float getFloat(String key, float defaultValue)
            throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            this.put(key, defaultValue + "");
            return defaultValue;
        }

        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException nfe) {
            throw new WebRequestException("Couldn't convert float: " + key
                    + " to float.", nfe);
        }
    }

    /**
     * Get an int, given the key.
     * 
     * @throws ReportException
     *             if there is a NumberFormatException or value is null.
     */
    public int getInt(String key) throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (value == null) {
            throw new WebRequestException(
                    "value is null for key: " + key + "!", null);
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new WebRequestException("Couldn't convert int: " + key
                    + " to int.", nfe);
        }
    }

    /**
     * An overloaded method of the getInt above. Passes in the int value that
     * will be used as default if the key does not exist.
     */
    public int getInt(String key, int defaultValue) throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            this.put(key, defaultValue + "");
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new WebRequestException("Couldn't convert int: " + key
                    + " to int.", nfe);
        }
    }

    /**
     * Get a boolean object, converting it from a String. If the String equals
     * (ignoring case) either "yes" or "true", then it returns true. Otherwise
     * false.
     */
    public boolean getBoolean(String key) throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            throw new WebRequestException("Key is null!", null);
        }

        if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("on")) {
            return true;
        } else if (value.equalsIgnoreCase("no")
                || value.equalsIgnoreCase("false")
                || value.equalsIgnoreCase("off")) {
            return false;
        } else {
            throw new WebRequestException(
                    "Value is not a valid boolean value: " + value, null);
        }
    }

    /**
     * An overloaded method of the getBoolean above. Passes a default value, in
     * case the key is not found in the Map.
     */
    public boolean getBoolean(String key, boolean defaultValue)
            throws WebRequestException
    {
        if (StringUtilities.isEmpty(key)) {
            throw new WebRequestException("key is empty!", null);
        }

        String value = (String) this.get(key);
        if (StringUtilities.isEmpty(value)) {
            String strDefaultValue = defaultValue ? "yes" : "no";
            this.put(key, strDefaultValue);
            return defaultValue;
        }

        if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("on")) {
            return true;
        } else if (value.equalsIgnoreCase("no")
                || value.equalsIgnoreCase("false")
                || value.equalsIgnoreCase("off")) {
            return false;
        } else {
            throw new WebRequestException(
                    "Value is not a valid boolean value: " + value, null);
        }
    }

    // HELPER METHODS
    /**
     * Generate a String representation of teh ParameterCollection.
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(" [--ParameterCollection--]\n");
        Set keys = this.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = (String) this.get(key);
            sb.append("   ");
            sb.append(key);
            sb.append(": ");
            sb.append(value);
            sb.append("\n");
        }
        return sb.toString();
    }

}
