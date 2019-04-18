
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * Implements a clock as a Runnable. Extends Observable to ease communication
 *
 */
public class Clock implements Runnable {
    private static Clock instance;
    private Microwave microwave;

    /**
     * Start the thread
     */
    private Clock() {
        this.microwave = Microwave.instance();
        new Thread(this).start();
    }

    public static Clock instance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                microwave.clockTicked();
            }
        } catch (InterruptedException ie) {
        }
    }
}
