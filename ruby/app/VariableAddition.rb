# VariableAddition[http://community.topcoder.com/stat?c=problem_statement&pm=4723]

class VariableAddition
  def self.solution (formula, vars)
    v = {}
    vars.each do |var|
      key, value = var.split
      v[key] = value.to_i
    end

    sum = 0
    formula.split('+').each do |t|
      if t[/\d+/]
        n = t.to_i
      else
        n = v[t]
      end
      sum += n
    end

    sum
  end
end
