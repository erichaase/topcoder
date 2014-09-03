# RabbitsAndCakes[http://community.topcoder.com/stat?c=problem_statement&pm=12787]

class RabbitsAndCakes
  def self.solution (minR, maxR, minC, maxC)
    pairs = []
    minR.upto(maxR) do |r|
      minC.upto(maxC) do |c|
        pairs << [r, c] if divisible(r, c)
      end
    end
    pairs.size
  end

  def self.divisible (r, c)
    each, parts = Rational(c, r), []
    r.times do
      c, parts = decrement(c, parts, each)
      return false if c < 0
    end
    parts.empty? ? true : false
  end

  def self.decrement (whole, parts, each)
    each -= parts.pop while ((not parts.empty?) && (each >= parts.last))
    c = each.floor
    p = each - c

    if p != 0
      parts.push(1 - p).sort!
      c += 1
    end

    [whole - c, parts]
  end
end
