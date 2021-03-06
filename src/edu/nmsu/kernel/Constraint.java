/*
 * Copyright (c) 2015.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package edu.nmsu.kernel;

import java.util.List;

/**
 * Created by ffiorett on 7/7/15.
 */
public interface Constraint extends DCOPobject {

    void addValue(Tuple key, int value, int optType);

    int getValue(Tuple values);

    int getBestValue();

    int getWorstValue();

    List<Variable> getScope();

    Variable getScope(int pos);

    int getDefaultValue();

    String toString();

    static boolean isUnsat(int value) {return (value >= Constants.infinity || value <= -Constants.infinity);}

    static boolean isSat(int value) {return !isUnsat(value);}

    static int add(int a, int b) {
        if(isUnsat(a) || isUnsat(b))
            return -Constants.infinity;
        return a + b;
    }
}
