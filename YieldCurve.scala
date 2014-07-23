/**
 *
 */
package YieldCurves

/**
 * @author Calvin Stewart
 *
 */
class YieldCurve(stepsPerYear: Int, ZCB: List[Double]) {

  def plot: List[(Double, Double)] =
    ZCB.zipWithIndex.map(x => (x._2.toDouble / stepsPerYear, x._1))

  def nCompYield(t: Double, z: Double, n: Int): Double =
    n *((math.pow((1/z),(1/(t*n)))) -1)
  
  def nCompYieldCurve(n: Int): List[Double] =
    plot.map(x => nCompYield(x._1,x._2,n))
    
}