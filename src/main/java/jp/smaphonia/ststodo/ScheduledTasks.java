package jp.smaphonia.ststodo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledTasks {
	
	@Scheduled(fixedRateString = "${scheduler.interval}")
	public void reportCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
}
