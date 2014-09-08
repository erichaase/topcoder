# RPN[http://community.topcoder.com/stat?c=problem_statement&pm=1632]

class RPN
  def self.solution (expr)
    stack = []

    expr.split.each do |t|
      case t
      when "~"
        return -999 if stack.size < 1
        stack << stack.pop * -1
      when "+"
        return -999 if stack.size < 2
        stack << stack.pop + stack.pop
      when "-"
        return -999 if stack.size < 2
        x = stack.pop
        y = stack.pop
        stack << y - x
      when "*"
        return -999 if stack.size < 2
        stack << stack.pop * stack.pop
      else
        stack << t.to_i
      end
    end

    if stack.size != 1
      -999
    else
      stack.pop
    end
  end
end
