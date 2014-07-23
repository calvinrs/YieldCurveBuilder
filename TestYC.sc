package YieldCurves

object TestYC {

	val aZCB = List(1.0,0.99, 0.98,0.97,0.96,0.95)
                                                  //> aZCB  : List[Double] = List(1.0, 0.99, 0.98, 0.97, 0.96, 0.95)
  
  val YC = new YieldCurve(12, aZCB)               //> YC  : YieldCurves.YieldCurve = YieldCurves.YieldCurve@7bf5f379
  
  
  YC.plot                                         //> res0: List[(Double, Double)] = List((0.0,1.0), (0.08333333333333333,0.99), (
                                                  //| 0.16666666666666666,0.98), (0.25,0.97), (0.3333333333333333,0.96), (0.416666
                                                  //| 6666666667,0.95))
  
  YC.nCompYieldCurve(1)                           //> res1: List[Double] = List(NaN, 0.12817809950197057, 0.12886899701576415, 0.1
                                                  //| 2956977477316278, 0.1302806712962965, 0.13100193332868426)
  
}