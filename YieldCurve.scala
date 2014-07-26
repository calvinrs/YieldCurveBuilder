/**
 *
 */
package YieldCurves

/**
 * @author Calvin Stewart
 *
 */
class YieldCurve(stepsPerYear: Int, ZCB: List[Double]) {

  val plot: List[(Double, Double)] =
    ZCB.zipWithIndex.map(x => (x._2.toDouble / stepsPerYear, x._1))
    
   def plotBase0(inCurve: List[(Double)]): List[(Double, Double)] =
    (inCurve zip (Stream from 0)).map(x => (x._2.toDouble / stepsPerYear, x._1)).dropWhile(_._2.isNaN == true)
    
  def nCompYield(t: Double, z: Double, n: Int): Double =
    n *((math.pow((1/z),(1/(t*n)))) -1)
    
  def contCompYield(t: Double, z: Double): Double =
    -math.log(z)/t
  
  def nCompYieldCurve(n: Int): List[Double] = 
    if (n == 0) 
      plot.map(x =>  contCompYield(x._1,x._2))
    else    
      plot.map(x => nCompYield(x._1,x._2,n))
    
   def calcFwdRates(iZCB: List[(Double, Double)], stepsPerYear: Int) = {
       def ZCBtoFWD(zs: List[(Double, Double)],fs: List[Double]): List[Double]= zs match {
              case Nil => fs
              case z1 :: Nil => fs.head :: fs
              case z1 :: z2 :: zs => ZCBtoFWD(z2 :: zs, ((z1._2/z2._2)-1) / (1.0/stepsPerYear) :: fs)
       }
       ZCBtoFWD(iZCB,Nil).reverse
  }
  
  val fwdRates = calcFwdRates(this.plot, stepsPerYear)
    
    
}