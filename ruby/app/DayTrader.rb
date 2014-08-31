# DayTrader[http://community.topcoder.com/stat?c=problem_statement&pm=7721]

class DayTrader
  NMIN = 390

  def self.earnings (timeA, priceA, timeB, priceB)
    pa = Array.new(NMIN + 1, nil)
    pb = Array.new(NMIN + 1, nil)
    0.upto(NMIN) do |t|
      pa[t] = price(t, timeA, priceA)
      pb[t] = price(t, timeB, priceB)
    end

    b = 1000
    1.upto(NMIN) do |t|
      pda = (pa[t] - pa[t-1]) / pa[t-1] + 1
      pdb = (pb[t] - pb[t-1]) / pb[t-1] + 1
      b *= [1, pda, pdb].max
    end
    return b - 1000
  end

  def self.price (t, times, prices)
    times.each_index do |i|
      ti, tj = times[i],       times[i+1]
      pi, pj = prices[i].to_f, prices[i+1].to_f

      if t == ti
        return pi.to_f
      elsif t == tj
        return pj.to_f
      elsif t < tj
        s = (pj - pi) / (tj - ti)
        return pi + s * (t - ti)
      end
    end
  end
end
