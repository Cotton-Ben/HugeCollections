
package net.openhft.collections.fromdocs.polling_latency;

import net.openhft.collections.SharedHashMap;
import net.openhft.collections.SharedHashMapBuilder;
import net.openhft.collections.fromdocs.BondVOInterface;
import net.openhft.lang.model.DataValueClasses;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class OffHeapAccessorShortTerm {

	@Test
	public void bondExample() throws IOException, InterruptedException {

		SharedHashMap<String, BondVOInterface> shmC = new SharedHashMapBuilder()
				.generatedValueType(true)
				.entrySize(320)
				.create(
						new File("/dev/shm/BondPortfolioSHM"),
						String.class,
						BondVOInterface.class
				);

		BondVOInterface bondOffHeap = DataValueClasses.newDirectReference(BondVOInterface.class);
		BondVOInterface _bondEntryV = shmC.acquireUsing("369604103", bondOffHeap);
		double _coupon = 0.0;
		//assertEquals(5.0 / 100, _coupon = _bondVO.getCoupon(), 0.0);

		//long _start = System.nanoTime();
		System.out.printf("\n\nLongTerm: Timing 1 x off-heap operations on /dev/shm/RDR_DIM_Mock\n");
		//
		for (int i = 0; i < 10000; i++) {

			long _start = System.nanoTime();
			_coupon = _bondEntryV.getCoupon();

			long _duration = System.nanoTime() - _start;
			System.out.printf("#%d:  1 x _bondEntryV.getCoupon() (last _coupon=[%.2f %%]) in %.1f nanos\n",
					i,
					_coupon,
					_duration / 1.0);
			//Thread.sleep(1);
		}
//	    long _duration = System.nanoTime() -_start;
//	    System.out.printf("1 million _bondEntryV.getCoupon() (last _coupon=[%.2f %%]) in %.1f nanos\n",
//			    _coupon,
//				_duration/1.0);
	}
}
