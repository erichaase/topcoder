# AustrianLotto[http://community.topcoder.com/stat?c=problem_statement&pm=1934]

class AustrianLotto
  def self.solution (drawing, picks)
    drawing = drawing.split.collect { |d| d.to_i}
    picks   = picks.collect { |p| p.split.collect { |q| q.to_i } }

    results = [0, 0, 0, 0, 0, 0, 0]
    picks.each { |p| results[matches(drawing,p)] += 1 }
    return results
  end

  def self.matches (drawing, picks)
    dh = {}
    drawing.each { |d| dh[d] = true }

    count = 0
    picks.each { |p| count += 1 if dh.has_key?(p) }
    return count
  end
end
