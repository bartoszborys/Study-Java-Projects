/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maclaurin.server.resources;

import java.time.Instant;

/**
 * Throws exception if find timeout
 * 
 * @author Bartek
 * @version 3.0
 */
public class TimeoutGuardian {

    /**
     * @param startTime start time
     * @param actualTime actual time
     * @param timeout timeout time 
     */
    private long startTime;
    private long actualTime;
    private long timeout = 5;

    /**
     * sets timeout
     * @param timeout timeout time 
     */
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    /**
     * sets start time
     */
    public void start() {
        startTime = Instant.now().getEpochSecond();
    }

    /**
     * check timeout and returns state
     * 
     * @return timeout state
     */
    public boolean checkTimeout() {
        actualTime = Instant.now().getEpochSecond();
        return ((startTime + timeout) <= actualTime);
    }
}
