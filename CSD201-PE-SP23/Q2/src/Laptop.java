// =========================================================
// Do NOT modify this file 
// =========================================================

class Laptop {
    String name;
    double price;
    int color;
    
    // Default constructure
    Laptop () {}
    
    // Constructor with full parameter
    Laptop (String xName, double xPrice, int xColor) {
        this.name = xName;
        this.price = xPrice; 
        this.color = xColor;
    }
    
    @Override
    public String toString(){
        return "(" + name + "," + price + "," + color + ")";
    }

    public double getPrice() {
        return this.price;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setColor(int inColor) {
        this.color = inColor;
    }
    
    public void setPrice(double inPrice) {
        this.price = inPrice;
    }
    
    public void setName(String inName) {
        this.name = inName;
    }
}