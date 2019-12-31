public class Planet {
  
  public double xxPos; // Its current x position
  public double yyPos; // Its current y position
  public double xxVel; // Its current velocity in the x direction
  public double yyVel; // Its current velocity in the y direction
  public double mass;  // Its mass
  public String imgFileName;

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

}
