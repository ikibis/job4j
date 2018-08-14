package ru.job4j.condition;
/**
 * @author Ilya Kibis (mailto:ilya.kibis@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
   private Point a;
   private Point b;
   private Point c;

   public Triangle(Point a, Point b, Point c) {
       this.a = a;
       this.b = b;
       this.c = c;
    }
/**
* ћетод вычислени¤ полупериметра по длинам сторон.
*
* ‘ормула.
*
* (ab + ac + bc) / 2
*
* @param ab рассто¤ние между точками a b
* @param ac рассто¤ние между точками a c
* @param bc рассто¤ние между точками b c
* @return ѕеримент.
*/
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2; 
    }
/**
* ћетод вычисл¤ет площадь треугольника.
*
* @return ¬ернуть прощадь, если треугольник существует или -1, если треугольника нет.
*/
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Ёто значение говорит о том. что треугольника нет.
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(
                p * (p - ab) * (p - ac) * (p - bc)
            ); 
        }
        return rsl;
    }
/**
* ћетод провер¤ет можно ли построить треугольник с такими длинами сторон.
* 
* ”словие, чтобы определить можно ли построить треугольник.
* 
* @param ab ƒлина от точки a b. 
* @param ac ƒлина от точки a c.
* @param bc ƒлина от точки b c.
* @return true / false
*/
    private boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ac + bc) > ab && (ab + bc) > ac;
    }
}