/*
 * Java programming language course examples.
 *
 * Copyright (c) 2015  Pavel Tisnovsky, Red Hat
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Red Hat nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Pavel Tisnovsky BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */



class DLThread extends Thread {
    String s1;
    String s2;

    public DLThread(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(this.s1) {
                synchronized(this.s2) {
                    System.out.println(this.s1+this.s2);
                }
            }
        }
    }
}

public class DeadLock2
{
    public static void main(String[] args) {
        String s1 = "Dead";
        String s2 = "Lock";
        String s3 = "?";
        new DLThread(s1, s2).start();
        new DLThread(s2, s1).start();
        new DLThread(s1, s3).start();
        new DLThread(s2, s3).start();
        new DLThread(s3, s1).start();
    }
}

