/*
 * Question 1:
 * The difference when we declare a Class method compared to an Instance method,
 * is in the keyworad static, when we declare a Class method we put static in the declaration
 * (ex. public static Fraction methodName()), where as for an Instance method we do not include the static
 * (ex. public Fraction methodName()).
 *
 * Question 2:
 * a) We would refer to a class method by using the class name and then the name of the method (ex. className.methodName(parameters)
 * b) We would refer to an instance method by using the name of an object and the method name (ex. objectName.methodName(parameters)
 *
 * Question 4:
 * In order to declare a class field we add the keyword static to the declaration, for an instance field we do not add the keyword static 
 *
 * Question 5:
 * We refer to a class field by using the class name and the name of the field, whereas we refer to an instance field by the object name and 
 * the name of the field
 */
package fractiontester;

/**
 *
 * @author 342720539
 */
public class FractionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] pNums = {1, 7, 5, -9, 5};
        int[] pDenum = {3, -5, 6, -12, 8};
        int[] qNums = {4, -9, -25, -3, 13};
        int[] qDenum = {5, -7, -30, 4, 20};

        for (int i = 0; i < pNums.length; i++) {
            Fraction p = new Fraction(pNums[i], pDenum[i]);
            Fraction q = new Fraction(qNums[i], qDenum[i]);
            Fraction r = p.larger(q);

            System.out.println(r.num + "/" + r.denum);
        }
        System.out.println("");

        Fraction w = new Fraction(4, 5);
        Fraction t = new Fraction(3, 6);

        w.timesEquals(t);

        System.out.println(w.num + "/" + w.denum);

        Fraction b = new Fraction(-12, 16);
        b.reduce();
        System.out.println(b.num + "/" + b.denum);

        Fraction a = new Fraction(8.343);

        System.out.println(a.num + "/" + a.denum);
        
        System.out.println(Fraction.times(a,b));
        
        System.out.println(Fraction.isPositive(b));
        
        System.out.println(Fraction.abs(b));
    }

}
