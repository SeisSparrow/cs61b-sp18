public class Planet {
  
  public double xxPos; // Its current x position
  public double yyPos; // Its current y position
  public double xxVel; // Its current velocity in the x direction
  public double yyVel; // Its current velocity in the y direction
  public double mass;  // Its mass
  public String imgFileName;
  final static double G = 6.67e-11;

  public Planet(double xP, double yP, double xV, 
		double yV, double m, String img) {
  
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass  = m;
    imgFileName = img;
  }
 
  public Planet(Planet p) {

    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass  = p.mass;
    this.imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {

    double dx2 = Math.pow(p.xxPos - this.xxPos, 2);
    double dy2 = Math.pow(p.yyPos - this.yyPos, 2);
    return Math.sqrt(dx2 + dy2);
  }

  public double calcForceExertedBy(Planet p) {

    return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
  }

  public double calcForceExertedByX(Planet p) {
   
    return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
  }

  public double calcForceExertedByY(Planet p) {

    return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
  }

  public double calcNetForceExertedByX(Planet[] ps) {

    double sum_x = 0; 

    for (Planet p: ps) {
    
      if (!this.equals(p)) {

        sum_x = sum_x + this.calcForceExertedByX(p);
      }
    }

    return sum_x;
  }

  public double calcNetForceExertedByY(Planet[] ps) {

    double sum_y = 0;

    for (Planet p: ps) {

      if (!this.equals(p)) {

        sum_y = sum_y + this.calcForceExertedByY(p);
      }
    }

    return sum_y;
  }
}
