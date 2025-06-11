package com.lotus.jewel.sample.thread;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class VirtualThreadPerTaskExecuter {

	public static void main(String[] args) throws Exception {
		run();
	}

	public static void run() throws Exception {
		for (int cur = 0; cur < 10; cur++) {
			long start = System.nanoTime();

			try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
				List<Future<Void>> futures = new ArrayList<>();

				for (int i = 0; i < 100_000; i++) {
					Future<Void> future = executor.submit(() -> {
						try {
							Thread.sleep(Duration.ofSeconds(2));
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt(); // good practice
						}
						return null;
					});
					futures.add(future);
				}

				// 모든 작업 완료 대기
				for (Future<Void> f : futures) {
					f.get(); // 예외 발생 시 throw
				}
			}

			long end = System.nanoTime();
			System.out.printf("Run %d: %.2f seconds%n", cur + 1, (end - start) / 1_000_000_000.0);
		}
	}

	public static void runOld() throws Exception {
		for (var cur = 0 ; cur < 10 ; cur++ ) {
			long start = System.currentTimeMillis();
			try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
				// 10만개의 Virtual Thread 실행
				for (int i = 0; i < 100_000; i++) {
					executor.submit(() -> {
						Thread.sleep(Duration.ofSeconds(2));
						return null;
					});
				}

			}
			long end = System.currentTimeMillis();
			System.out.println((end - start) + "ms");
		}
	}
}
