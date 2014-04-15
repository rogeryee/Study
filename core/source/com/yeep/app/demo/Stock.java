package com.yeep.app.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Stock
{
	public static double stampTaxRate = 0.001;
	public static double commissionRate = 0.00198;
	public static double transferRate = 0.001;

	public static void main(String[] args)
	{
		Session session = new Session("600595");
		session.setShanghaiStock(true);
		Stock.buyStock(session, 700, 12.20);
		Stock.buyStock(session, 1000, 12.10);
	}

	/**
	 * 购买股票的操作
	 * @param session
	 */
	public static void buyStock(Session session, int buyAmount, double buyPrice)
	{
		BuyDeal deal = new BuyDeal(buyPrice, buyAmount, session.isShanghaiStock());
		session.buy(deal);
		session.print();
	}

	/**
	 * 卖出股票的操作
	 * @param session
	 */
	public static void sellStock(Session session, int sellAmount, double sellPrice)
	{
		SellDeal deal = new SellDeal(sellPrice, sellAmount, session.isShanghaiStock());
		session.sell(deal);
		session.print();
	}

	/**
	 * 计算保本价
	 * @param buyCost
	 * @param deal
	 * @return
	 */
	public static double calculatePerferredSellPrice(double cost, int amount, boolean isShanghaiStock)
	{
		SellDeal deal = new SellDeal(0.0, amount, isShanghaiStock);
		deal.setPrice(0.0);
		while (cost > calculateSellIncoming(deal))
		{
			deal.setPrice(deal.getPrice() + 0.01);
		}

		return MathHelper.round(deal.getPrice(), 3);
	}

	/**
	 * 计算购买成本
	 * @param deal
	 * @return
	 */
	public static double calculateBuyCost(BuyDeal deal)
	{
		double buyFee = deal.getAmount() * deal.getPrice();
		double buyCommissionFee = calculateCommissionFee(deal);
		double buyTransferFee = calculateTransferFee(deal);
		double buyStamptaxFee = calculateStampTaxFee(deal);

		//		System.out.println("购买金额 = " + buyFee);
		//		System.out.println("购买佣金 = " + buyCommissionFee);
		//		System.out.println("购买过户费 = " + buyTransferFee);
		//		System.out.println("购买印花税 = " + buyStamptaxFee);

		return MathHelper.round(buyFee + buyCommissionFee + buyTransferFee + buyStamptaxFee, 3);
	}

	/**
	 * 计算卖出收入
	 * @param deal
	 * @return
	 */
	public static double calculateSellIncoming(SellDeal deal)
	{
		double sellFee = deal.getAmount() * deal.getPrice();
		double sellTransferFee = calculateTransferFee(deal);
		double sellCommissionFee = calculateCommissionFee(deal);
		double sellStamptaxFee = calculateStampTaxFee(deal);

		//		System.out.println("卖出金额 = " + sellFee);
		//		System.out.println("卖出佣金 = " + sellCommissionFee);
		//		System.out.println("卖出过户费 = " + sellTransferFee);
		//		System.out.println("卖出印花税 = " + sellStamptaxFee);

		return MathHelper.round(sellFee - sellTransferFee - sellCommissionFee - sellStamptaxFee, 3);
	}

	/**
	 * 计算过户费
	 * @param deal
	 * @return
	 */
	private static double calculateTransferFee(Deal deal)
	{
		if (deal instanceof BuyDeal)
			return 0.0;

		if (deal.getAmount() < 1000)
			return 1.0d;
		else
			return deal.getAmount() * 0.001;
	}

	/**
	 * 计算佣金
	 * @param deal
	 * @return
	 */
	private static double calculateCommissionFee(Deal deal)
	{
		double fee = MathHelper.round(deal.getAmount() * deal.getPrice() * commissionRate, 3);

		if (fee < 5.0d)
			return 5.0d;
		else
			return fee;
	}

	/**
	 * 计算印花税
	 * @param deal
	 * @return
	 */
	private static double calculateStampTaxFee(Deal deal)
	{
		if (deal instanceof BuyDeal)
			return 0.0;

		return MathHelper.round(deal.getAmount() * deal.getPrice() * stampTaxRate, 3);
	}
}

class Deal
{
	private double price;
	private int amount;
	private boolean shanghaiStock;

	public Deal()
	{

	}

	public Deal(double price, int amount, boolean shanghaiStock)
	{
		this.price = price;
		this.amount = amount;
		this.shanghaiStock = shanghaiStock;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public boolean isShanghaiStock()
	{
		return shanghaiStock;
	}

	public void setShanghaiStock(boolean shanghaiStock)
	{
		this.shanghaiStock = shanghaiStock;
	}
}

class BuyDeal extends Deal
{
	public BuyDeal(double price, int amount, boolean shanghaiStock)
	{
		super(price, amount, shanghaiStock);
	}
}

class SellDeal extends Deal
{
	public SellDeal(double price, int amount, boolean shanghaiStock)
	{
		super(price, amount, shanghaiStock);
	}
}

class Session
{
	private String stockId;
	private int amount;
	private double totalCost;
	private double totalIncoming;
	private boolean shanghaiStock;
	private List<BuyDeal> buyDeals = new ArrayList<BuyDeal>();
	private List<SellDeal> sellDeals = new ArrayList<SellDeal>();

	// Constructor
	public Session(String stockId)
	{
		this.stockId = stockId;
	}

	/**
	 * 买股票
	 * @param deal
	 */
	public void buy(BuyDeal deal)
	{
		this.totalCost = this.totalCost + Stock.calculateBuyCost(deal);
		this.amount = this.amount + deal.getAmount();
		getBuyDeals().add(deal);
	}

	/**
	 * 卖股票
	 * @param deal
	 */
	public void sell(SellDeal deal)
	{
		double incoming = Stock.calculateSellIncoming(deal);
		this.totalCost = this.totalCost - incoming;
		this.totalIncoming = this.totalIncoming + incoming;
		this.amount = this.amount - deal.getAmount();
		getSellDeals().add(deal);
	}

	/**
	 * 计算保本价
	 * @return
	 */
	public double getPerferredSellPrice()
	{
		return MathHelper.round(Stock.calculatePerferredSellPrice(totalCost, amount, shanghaiStock), 2);
	}

	/**
	 * Print
	 * @param session
	 */
	public void print()
	{
		System.out.println("Cost = " + MathHelper.round(this.getTotalCost(), 3) + ", Incoming = "
				+ MathHelper.round(this.getTotalIncoming(), 3) + ", perferred price = " + this.getPerferredSellPrice());
	}

	// Getters and Setters
	public int getAmount()
	{
		return amount;
	}

	public double getTotalCost()
	{
		return totalCost;
	}

	public boolean isShanghaiStock()
	{
		return shanghaiStock;
	}

	public void setShanghaiStock(boolean shanghaiStock)
	{
		this.shanghaiStock = shanghaiStock;
	}

	public List<BuyDeal> getBuyDeals()
	{
		return buyDeals;
	}

	public List<SellDeal> getSellDeals()
	{
		return sellDeals;
	}

	public double getTotalIncoming()
	{
		return totalIncoming;
	}
}

class MathHelper
{
	private static final int DEF_DIV_SCALE = 10;

	/**
	* 提供精确的加法运算。
	* @param v1 被加数
	* @param v2 加数
	* @return 两个参数的和
	*/
	public static double add(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	* 提供精确的减法运算。
	* @param v1 被减数
	* @param v2 减数
	* @return 两个参数的差
	*/
	public static double sub(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	* 提供精确的乘法运算。
	* @param v1 被乘数
	* @param v2 乘数
	* @return 两个参数的积
	*/
	public static double mul(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	* 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	* 小数点以后10位，以后的数字四舍五入。
	* @param v1 被除数
	* @param v2 除数
	* @return 两个参数的商
	*/
	public static double div(double v1, double v2)
	{
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	* 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	* 定精度，以后的数字四舍五入。
	* @param v1 被除数
	* @param v2 除数
	* @param scale 表示表示需要精确到小数点以后几位。
	* @return 两个参数的商
	*/
	public static double div(double v1, double v2, int scale)
	{
		if (scale < 0)
		{
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	* 提供精确的小数位四舍五入处理。
	* @param v 需要四舍五入的数字
	* @param scale 小数点后保留几位
	* @return 四舍五入后的结果
	*/
	public static double round(double v, int scale)
	{
		if (scale < 0)
		{
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
