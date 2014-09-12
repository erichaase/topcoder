# Series[http://community.topcoder.com/stat?c=problem_statement&pm=64]

class Series
  def self.solution (param0)
    series = []
    last   = param0[0]
    s      = [last]

    param0[1..-1].each do |p|
      if p > last
        s << p
      else
        series << s
        s = [p]
      end
      last = p
    end
    series << s

    series.sort! { |a, b| a.size <=> b.size }[-1].size
  end
end
