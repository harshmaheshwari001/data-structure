package designPattern;

import exception.CreditCardException;
import exception.CustomRunTimeException;

interface IPaymentGateWay {
	// Properties setter
	void setCardNumber(final String cardNumber) throws CustomRunTimeException;

	void setName(final String name) throws CustomRunTimeException;

	void setExpiry(final String expiryDate) throws CustomRunTimeException;

	// Properties getter
	String getCardNumber() throws CustomRunTimeException;

	String getName() throws CustomRunTimeException;

	String getExpiry() throws CustomRunTimeException;

}

class Paytm implements IPaymentGateWay {
	private String cardNumber;
	private String name;
	private String expiryDate;

	@Override
	public void setCardNumber(String cardNumber) throws CustomRunTimeException {
		// TODO Auto-generated method stub
		this.cardNumber = cardNumber;
	}

	@Override
	public void setName(String name) throws CustomRunTimeException {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setExpiry(String expiryDate) throws CustomRunTimeException {
		// TODO Auto-generated method stub
		this.expiryDate = expiryDate;
	}

	@Override
	public String getCardNumber() throws CustomRunTimeException {
		// TODO Auto-generated method stub
		return this.cardNumber;
	}

	@Override
	public String getName() throws CustomRunTimeException {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getExpiry() throws CustomRunTimeException {
		// TODO Auto-generated method stub
		return this.expiryDate;
	}

}

interface ICreditCardGateWay {

	void setCardNumber(String cardNumber) throws CreditCardException;

	void setCustName(String custName) throws CreditCardException;

	void setExpiredOn(String expiredOn) throws CreditCardException;

	void setCardType(String cardType) throws CreditCardException;

	String getCardNumber() throws CreditCardException;

	String getExpiredOn() throws CreditCardException;

	String getcustName() throws CreditCardException;

	String getCardType() throws CreditCardException;
}

class BillDesk implements ICreditCardGateWay {
	private String cardNumber;
	private String custName;
	private String expiredOn;
	private String cardType;

	public BillDesk() {
		// TODO Auto-generated constructor stub
	}

	public BillDesk(IPaymentGateWay paymentGateway, String cardType) {
		adaptorMethod(paymentGateway, cardType);
	}

	@Override
	public void setCardNumber(String cardNumber) throws CreditCardException {
		this.cardNumber = cardNumber;

	}

	@Override
	public void setCustName(String custName) throws CreditCardException {
		// TODO Auto-generated method stub
		this.custName = custName;
	}

	@Override
	public void setExpiredOn(String expiredOn) throws CreditCardException {
		// TODO Auto-generated method stub
		this.expiredOn = expiredOn;
	}

	@Override
	public void setCardType(String cardType) throws CreditCardException {
		this.cardType = cardType;

	}

	@Override
	public String getCardType() throws CreditCardException {
		// TODO Auto-generated method stub
		return this.cardType;
	}

	@Override
	public String getExpiredOn() throws CreditCardException {
		// TODO Auto-generated method stub
		return this.expiredOn;
	}

	@Override
	public String getcustName() throws CreditCardException {
		// TODO Auto-generated method stub
		return this.custName;
	}

	/**
	 * 
	 * @param paymentGateWay
	 */
	public void adaptorMethod(IPaymentGateWay paymentGateWay, String cardType) {
		setCardNumber(paymentGateWay.getCardNumber());
		setCustName(paymentGateWay.getName());
		setExpiredOn(paymentGateWay.getExpiry());
		setCardType(cardType);
	}

	@Override
	public String getCardNumber() throws CreditCardException {
		// TODO Auto-generated method stub
		return this.cardNumber;
	}
}

public class AdaptorDesignPattern {

	public static void main(String args[]) {
		IPaymentGateWay gateWary = new Paytm();
		gateWary.setCardNumber("1234");
		gateWary.setName("paytm");
		gateWary.setExpiry("1008");
		System.out.println(gateWary.getCardNumber());
		System.out.println(gateWary.getName());
		System.out.println(gateWary.getExpiry());
		
		// java Passby Reference where CopyGateway object is reference to same memory location as gateWary object
		IPaymentGateWay copyGateWay = gateWary;
		copyGateWay.setCardNumber("1111");
		copyGateWay.setName("Google Tez");
		copyGateWay.setExpiry("1108");
		

		System.out.println("################## Use of Adaptor Pattern #################");
		ICreditCardGateWay cardGateWay = new BillDesk(gateWary, "VISA");
		System.out.println(cardGateWay.getCardNumber());
		System.out.println(cardGateWay.getcustName());
		System.out.println(cardGateWay.getCardType());
		System.out.println(cardGateWay.getExpiredOn());

	}
}
