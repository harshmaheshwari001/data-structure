package designPattern;

import java.util.Date;
import java.util.logging.Logger;

import designPattern.Logging.Log;
import designPattern.SendSMS.SMS;

interface Job {
	public void execute();
}

class SendSMS implements Job {

	public static final Logger logger = Logger.getLogger(SendSMS.class.getName());

	private final SMS sms;

	public SendSMS(SMS sms) {
		super();
		this.sms = sms;
	}

	/**
	 * SMS Class
	 */
	static class SMS {
		private final String mobileNumber;
		private String country;
		private String operator;

		public SMS(String mobileNumber) {
			super();
			this.mobileNumber = mobileNumber;
		}

		public SMS setCountry(final String country) {
			this.country = country;
			return this;
		}

		public SMS setOperator(final String operator) {
			this.operator = operator;
			return this;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public String getCountry() {
			return country;
		}

		public String getOperator() {
			return operator;
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		logger.info("Sending SMS ....");
		logger.info("MobileNumber --- " + this.sms.getMobileNumber());
	}

}

class Logging implements Job {

	public static final Logger logger = Logger.getLogger(Logging.class.getName());

	private final Log log;

	public Logging(Log log) {
		super();
		this.log = log;
	}

	static class Log {
		private final String type;
		private final String message;

		public Log(String type, String message) {
			super();
			this.type = type;
			this.message = message;
		}

		public String getType() {
			return type;
		}

		public String getMessage() {
			return message;
		}

		public Date getTimeStamp() {
			return new Date();
		}

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		logger.info("Logging ...");
		logger.info(" [" + this.log.getType() + "] :" + this.log.getTimeStamp() + this.log.getMessage());
	}

}

public class CommandPattern {

	public static void main(String args[]) {
		Job job = new SendSMS(new SMS("8904615194"));
		job.execute();
		job = new Logging(new Log("INFO", "Calling Logging Job"));
		job.execute();
	}
}
