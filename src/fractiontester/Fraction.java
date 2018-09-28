/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiontester;

import java.util.*;

/**
 *
 * @author 342720539
 */
public class Fraction {

    int num;
    int denum;

    public Fraction(int a, int b) {
        num = a;
        denum = b;
    }

    public Fraction(Fraction a) {
        this.num = a.num;
        this.denum = a.denum;
    }

    public Fraction(double a) {
        String numStr = Double.toString(a);
        int count = numStr.length() - (numStr.indexOf(".") + 1);

        int newDenum = 10;

        do {
            newDenum *= 10;
            count--;
        } while (count != 1);

        double newNum = (double) a * newDenum;

        this.num = (int) newNum;
        this.denum = newDenum;
    }

    public double size() {
        return (double) this.num / (double) this.denum;
    }

    public Fraction larger(Fraction other) {
        if (this.size() >= other.size()) {
            return this;
        } else {
            return other;
        }
    }

    public void timesEquals(Fraction p) {
        int newNum = this.num * p.num;
        int newDenum = this.denum * p.denum;

        this.num = newNum;
        this.denum = newDenum;
    }

    public Fraction plus(Fraction f) {
        int commonDenum = this.denum * f.denum;
        int firstNum = this.num * f.denum;
        int secondNum = f.num * this.denum;
        int total = firstNum + secondNum;

        return new Fraction(total, commonDenum);
    }

    private List factors(int num, int denum) {
        List<Integer> factors = new ArrayList<>();
        if (num > denum) {
            for (int i = 1; i <= num; i++) {
                if (num % i == 0 & denum % i == 0) {
                    factors.add(i);
                }
            }
        } else {
            for (int i = 1; i <= denum; i++) {
                if (num % i == 0 & denum % i == 0) {
                    factors.add(i);
                }
            }
        }

        return factors;
    }

    public void reduce() {
        if (this.num == this.denum) {
            this.num = 1;
            this.denum = 1;
        } else {
            List<Integer> factors = factors(this.num, this.denum);

            Collections.sort(factors);

            this.num = this.num / factors.get(factors.size() - 1);
            this.denum = this.denum / factors.get(factors.size() - 1);

        }
    }
    
    public static Fraction times(Fraction one, Fraction two){
        int newNum = one.num*two.num;
        int newDenum = one.denum*two.denum;
        
        return new Fraction(newNum,newDenum);
    }
    
    public static Fraction abs(Fraction f){
        int newNum = Math.abs(f.num);
        int newDenum = Math.abs(f.denum);
        
        return new Fraction(newNum,newDenum);
    }
    
    public static boolean isPositive(Fraction e){
        if(e.num<0 | e.denum<0){
            return false;
        }else{
            return true;
        }
    }
}
