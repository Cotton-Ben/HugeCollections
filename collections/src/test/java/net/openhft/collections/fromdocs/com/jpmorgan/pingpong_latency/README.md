


* Compile the application by running `mvn clean compile dependency:copy-dependencies -DstripVersion`


* To try , run the following command in 2 separated terminals (Left player must be started first!):

    * `java  org.junit.runner.JUnitCore net.openhft.collections.fromdocs.com.jpmorgan.pingpong_latency.PingPongPlayerLeft

#32424:  1 x _bondEntryV.getCoupon() (last _couponL=[5.00 %]) in 37.0 nanos

#32425:  1 x _bondEntryV.getCoupon() (last _couponL=[5.00 %]) in 37.5 nanos

#32426:  1 x _bondEntryV.getCoupon() (last _couponL=[5.00 %]) in 31.0 nanos

#32427:  1 x _bondEntryV.getCoupon() (last _couponL=[5.00 %]) in 37.5 nanos

#32428:  1 x _bondEntryV.getCoupon() (last _couponL=[5.00 %]) in 37.0 nanos



    * `java  org.junit.runner.JUnitCore net.openhft.collections.fromdocs.com.jpmorgan.pingpong_latency.PingPongPlayerRight


#32423:  1 x _bondEntryV.getCoupon() (last _couponR=[4.00 %]) in 37.0 nanos

#32424:  1 x _bondEntryV.getCoupon() (last _couponR=[4.00 %]) in 31.0 nanos

#32425:  1 x _bondEntryV.getCoupon() (last _couponR=[4.00 %]) in 35.0 nanos

#32426:  1 x _bondEntryV.getCoupon() (last _couponR=[4.00 %]) in 36.5 nanos

#32427:  1 x _bondEntryV.getCoupon() (last _couponR=[4.00 %]) in 37.0 nanos




