/*
 * Copyright 1999-2002 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
package sun.awt.motif;
import java.awt.Image;

class MWindowAttributes {
    static int NORMAL           = 0;
    static int ICONIC           = 1;
    static int MAXIMIZED        = 2;

    static int AWT_DECOR_NONE        = 0;
    static int AWT_DECOR_ALL         = 1;
    static int AWT_DECOR_BORDER      = 2;
    static int AWT_DECOR_RESIZEH     = 4;
    static int AWT_DECOR_TITLE       = 8;
    static int AWT_DECOR_MENU        = 0x10;
    static int AWT_DECOR_MINIMIZE    = 0x20;
    static int AWT_DECOR_MAXIMIZE    = 0x40;
    static int AWT_UNOBSCURED        = 0;   // X11 VisibilityUnobscured
    static int AWT_PARTIALLY_OBSCURED = 1;  // X11 VisibilityPartiallyObscured
    static int AWT_FULLY_OBSCURED    =  2;  // X11 VisibilityFullyObscured
    static int AWT_UNKNOWN_OBSCURITY = 3;

    boolean nativeDecor;
    boolean initialFocus;
    boolean isResizable;
    int initialState;
    int visibilityState; // updated by native X11 event handling code.
    String title;
    java.awt.Image icon;
    int decorations;            // for future expansion to be able to
                                // specify native decorations

    private static native void initIDs();

    static {
        initIDs();
    }

    MWindowAttributes() {
        nativeDecor = false;
        initialFocus = false;
        isResizable = false;
        initialState = NORMAL;
        visibilityState = AWT_UNKNOWN_OBSCURITY;
        title = null;
        icon = null;
        decorations = 0;
    }
}
