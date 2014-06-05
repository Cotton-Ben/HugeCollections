
package net.openhft.collections.fromdocs.com.jpmorgan.pingpong_latency;

import net.openhft.collections.SharedHashMap;
import net.openhft.collections.SharedHashMapBuilder;
import net.openhft.collections.fromdocs.BondVOInterface;
import net.openhft.lang.model.DataValueClasses;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PingPongPlayerLeft {

	@Test
	public void bondExample() throws IOException, InterruptedException {

		SharedHashMap<String, BondVOInterface> shmLeft = new SharedHashMapBuilder()
				.generatedValueType(true)
				.entrySize(320)
				.create(
						new File("/dev/shm/BondPortfolioSHM"),
						String.class,
						BondVOInterface.class
				);

		BondVOInterface bondOffHeap = DataValueClasses.newDirectReference(BondVOInterface.class);
		//BondVOInterface _bondEntryV = shmLeft.acquireUsing("369604103", bondOffHeap);
		shmLeft.acquireUsing("369604103", bondOffHeap);
		double _couponLeft = 4.0;
		double _couponRight = 5.0;
		System.out.printf("\n\nPingPongLEFT: Timing 1 x off-heap operations on /dev/shm/RDR_DIM_Mock\n");

		bondOffHeap.setCoupon(_couponLeft);

		for (int i = 0; i < 500000; i++) {

			long _start = System.nanoTime(); //

			while (! bondOffHeap.compareAndSwapCoupon(_couponLeft,_couponRight))
				;

//			while ((_coupon = bondOffHeap.getCoupon()) == 4.0) {
//				shmLeft.acquireUsing("369604103", bondOffHeap);  //I want to remove this line!!
//				;
//			}

			long _duration = System.nanoTime() - _start;
			System.out.printf("#%d:  1 x _bondEntryV.getCoupon() (last _couponL=[%.2f %%]) in %.1f nanos\n",
					i,
					bondOffHeap.getCoupon(),
					_duration / 2.0);
			//Thread.sleep(1);
		}
	}
}
