

package net.openhft.collections.fromdocs.polling_latency;

import net.openhft.collections.SharedHashMap;
import net.openhft.collections.SharedHashMapBuilder;
import net.openhft.collections.fromdocs.BondVOInterface;
import net.openhft.lang.model.DataValueClasses;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * These code fragments will appear in an article on OpenHFT.  These tests to ensure that the examples compile and behave as expected.
 */
public class OffHeapMutator {


    @Test
    public void bondExample() throws IOException, InterruptedException {

		long shmTrial = System.currentTimeMillis();
        SharedHashMap<String, BondVOInterface> shmP = new SharedHashMapBuilder()
                .generatedValueType(true)
                .entrySize(512)
                .create(
                        new File("/dev/shm/BondPortfolioSHM"),
                        String.class,
                        BondVOInterface.class
                );


        BondVOInterface bondVO_OffHeap = DataValueClasses.newDirectReference(BondVOInterface.class);
        BondVOInterface _bondEntryV = shmP.acquireUsing("369604103", bondVO_OffHeap);

	    double _coupon  = 0.00;

	    for (;;) {
            _bondEntryV.setCoupon(_coupon = (2+ Math.random()*5.0));
	        System.out.printf("Mutated coupon=%.2f %%\n", _coupon);
		    //Thread.sleep(100);
	    }

    }


}
