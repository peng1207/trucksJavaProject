package com.hsp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.hsp.model.User;

public class TestController {
	
 
	private static int x = 0, y = 0;
    private static int a = 0, b =0;

	
	public static void main(String[] args) {
		// 保费
		double yearMoney = 30000; 
		// 存放多少年
		int year = 30;
		// 交几年的保费
		int crossYear = 3;
		// 利率
		double rate = 0.045;
		bunan(yearMoney, year, rate,crossYear);
//		nan(yearMoney, year, rate,crossYear);
//		fuli(yearMoney, year, rate, 12,crossYear);
//		daikuan(12000, 0.04, 12);
//		gupiao(8, 10);
//		try {
//			test();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		cifan(10, 32);
	 
	}
	/**
	 * 计算不拿 存几年的总金额
	 * @param yearMoney 每年存的金额
	 * @param year	总共几年
	 * @param rate 利率
	 * @param crossYear 需要存几年
	 */
	public static void bunan(double yearMoney , int year,double rate,int crossYear ) {
		// 最终获取到的金额
		double totalMoney = 0;
		double totalNaMoney = 0;
		boolean isNan = false;
		for (int i = 1; i <= year; i++) {
			if (i <= crossYear) {
				totalMoney += yearMoney;
			}
			System.out.println("第" + i + "年头的本金为:" + totalMoney);
			if (isNan) {
				double naMoney = 0;
				if (i >= 18 && i <= 21) {
					naMoney = 75000;
				}else if (i == 30) {
					naMoney = 300000;
				}else if (i >= 65 && i <= 90) {
					naMoney = 45000;
				}
				totalMoney = totalMoney - naMoney;
				totalNaMoney = totalNaMoney + naMoney;
				System.out.println("第" + i + "年头拿的金额为:" + naMoney + " 剩余本金为:" + totalMoney);
				
			}
			double interest = totalMoney * rate; 
			totalMoney = interest + totalMoney;
			System.out.println("第" + i + "年的利息为:" + interest);
			System.out.println("第" + i + "年未本金加利息为:" + totalMoney);
			System.out.println("--------------------------------");
		}
		System.out.println(year + "年后拿到的金额为:" + totalMoney);
		System.out.println(year + "年后拿到的利息为:" + (totalMoney - yearMoney * crossYear));
		System.out.println("总共获取到的金额" + (totalNaMoney + (totalNaMoney > 0 ? 76000 : 0) ));
	}
	/**
	 * 计算第几年开始拿的金额
	 * @param yearMoney 每年存的金额
	 * @param year	总的年数
	 * @param rate	利率
	 * @param crossYear 需要存几年
	 */
	public static void nan(double yearMoney , int year,double rate ,int crossYear) {
		// 本金
		double totalMoney = 0;
		// 最终获取到金额
		double takeTotalMoney = 0;
		// 保额
		double insuranceAmount = 20400; 
		for (int i = 1; i <= year; i++) {
			if (i <= crossYear) {
				totalMoney += yearMoney;
			}
			// 每年拿到的金额
			double yearTakeMoney = 0;

			System.out.println("第" + i + "年头的本金为:" + totalMoney);
			// 利息 
			double interest = totalMoney * rate; 
			totalMoney = interest + totalMoney;
			System.out.println("第" + i + "年的利息为:" + interest);
			System.out.println("第" + i + "年未本金加利息为:" + totalMoney);
			
			if (i < 5) {
				yearTakeMoney = 0;
			}else if (i < 7) {
				yearTakeMoney = yearMoney * 0.6;
			}else if (i < year) {
				yearTakeMoney = insuranceAmount * 0.3;
			}else if (i == year) {
				yearTakeMoney = insuranceAmount;
			}
			System.out.println("第" + i + "年拿出来的金额为:" + yearTakeMoney);
			totalMoney = totalMoney - yearTakeMoney;
			System.out.println("第" + i + "年剩余的本金为" + totalMoney);
			takeTotalMoney += yearTakeMoney;
			System.out.println("--------------------------------");
		}
		System.out.println(year + "年后总共能拿到的金额为:" + takeTotalMoney);
		System.out.println(year + "年后拿到的利息为:" + (takeTotalMoney - yearMoney * crossYear));
	}
	/**
	 * 计算复利
	 * @param yearMoney 年存进去金额
	 * @param year	多少年
	 * @param rate	利率
	 * @param month 年复利次数
	 * @param crossYear 需要交多少年
	 */
	public static void fuli(double yearMoney , int year,double rate ,int month,int crossYear ) {
		// 最终获取到的金额
		double totalMoney = yearMoney;
		double totalInterest = 0; 
		for (int i = 1; i <= year * month; i++) {
			if ((i / month < crossYear && i % month == 1 && i != 1) || (month == 1 && i <= crossYear && i != 1)) {
				totalMoney += yearMoney;
			}
			System.out.println(i + "月的本金:" + totalMoney);
			double interest = totalMoney * (rate / month); 
			System.out.println(i + "月该月获取到利息:"+ interest);
			totalMoney = interest + totalMoney;
			totalInterest += interest;
			System.out.println(i + "月总获取利息" + totalInterest);
		}
		System.out.println("获取到总金额为:" + totalMoney);
	}
	/**
	 *  计算贷款的总利息 和还款详细
	 * @param money	贷款总金额
	 * @param rate	贷款年利率
	 * @param month	贷款总月份
	 */
	public static void daikuan(double money,double rate ,int month) {
		double totalMoney = money;
		double totalInterest = 0; 
		double monthMoney = money / month;
		System.out.println("每个月的本金" + monthMoney);
		for (int i = 1; i <= month; i++) {
			double interest = totalMoney * (rate / 12); 
			System.out.println("每个月利息:" + interest);
			totalMoney = totalMoney - monthMoney;
			System.out.println("剩余的金额:" + totalMoney);
			totalInterest += interest;
		}
		System.out.println("总利息为:" + totalInterest);
	}
	public static void gupiao(double price,int day) {
		double totalPrice = price; 
		for (int i = 0; i < day; i++) {
			totalPrice = totalPrice + totalPrice * 0.1;
		}
		System.out.println(day + "天该股票的价格为:" + totalPrice);
	}
	public static void test() throws InterruptedException {
		int i = 0;
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                a = 1;
                x = b;
            });  
            
            Thread other = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                b = 1;
                y = a;
            });
            one.start();other.start();
            latch.countDown();
            one.join();
            other.join();
            
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
	}
	public static void cifan(int num,int cifan) {
		long total = 1; 
		for (int i = 0; i < cifan; i++) {
			total = total * num;
			System.out.println(num + "的" + cifan + "次方的结果位:" + total);
		}
//		System.out.println(num + "的" + cifan + "次方的结果位:" + total);
	}
}

/**
 * 
 *  编号由字母和数字组成两位数 前面先由数字组合 等数字组合完之后在由字母和数字组合
 *  规格表: id 名称 编号
 *  规格明细表: id 名称 规格ID 编号
 *  品牌表: id 名称
 *  单位表: id 名称
 *  分类表: id 名称 别名 图片 父类ID
 *  
 *  货号:7位
 *  skuID:5位
 *  时间戳:10位
 *   
 *   
 *  每件商品的身份ID(numberID) 货号+skuid+时间戳(到秒)
 *  用户表:
 *  商品表:id 标题 货号 创建时间 更新时间 创建ID 更新ID  商品规格 品牌ID 单位 产地 状态
 *  商品明细表:id 商品ID skuid 数量 价格 图片
 *  商品sku明细表:id 商品明细ID 规格ID 规格明细ID （例如 规格ID 颜色 规格明细ID 红色 是一条数据）
 *  仓库表:id numberID 商品ID skuID 订单ID 状态(正在制作、可售、已售、不可售) 备注 创建时间 更新时间 创建ID 更新ID 订单来源(订单表、订货表)
 *  仓库退货表: id 仓库ID 订单ID 订单来源(订单表、订货表) 备注 创建时间 更新时间 创建ID 更新ID
 * 	订单表:id 单号 第三方订单ID 配送方式 第三方物流单号 第三方物流名称 第三方物流缩写 来源 创建时间 更新时间 状态
 * 	订单明细表:id 商品ID 货号 skuID 数量 价格 总额 应付金额
 * 	订货表:id 单号 用户 付款方式 付款状态 地址ID 配送方式 第三方物流单号 第三方物流名称 第三方物流缩写 创建时间 更新时间 创建ID 更新ID 状态 总额 运费 优惠金额 应付金额
 *  订货商品表:id 商品ID 货号 skuID 数量 价格 总额 应付价格 创建时间 更新时间 创建ID 更新ID
 *  物流表:id 单号 配送方式 第三方物流单号 第三方物流名称 状态(已下单 处理中 发货 待收货 签收 取消) 来源(第三方订单、订货系统)
 *  物流明细表:id 物流ID 状态 描述
 *  月结表:id 用户ID 年 月 月结最后付款时间 付款金额 付款时间 是否超时付款 违约金 总付款金额 付款方式
 *  月结详细表:id 月结ID 订货ID 金额 时间 
 *  商品记录表:id numberID（每件商品身份ID）描述 创建时间 创建ID
 *  
 *  付款方式：按照约定付款（月结）、(支付宝、微信、银联)等第三方支付方式、线下支付(现金支付、支票、支付宝/微信扫码)
 *  付款状态：转月结 未付款 付款待确认 已付款 
 *  配送方式: 自提 自己配送 第三方配送(快递公司、物流公司) 
 *  物流状态：用户已下单 等待系统确认 系统已确认 系统已打单 等待配货 在配货 配货完成 等待提货 等待安排配送员 已安排配送员 订单已交给第三方 等待收货 已签收 物流配送完成
 *  用户支付成功或根据系统规则可以欠款发货或第三方订单状态未待发货(已付款)状态下 生成一条物流信息
 *  
 *  
 *  
 * */
