# RepeatedSubstrings[http://community.topcoder.com/stat?c=problem_statement&pm=2004]

class RepeatedSubstrings
  def self.solution (compressed)
    out = ""
    begin
      before = String.new(out)
      out = process(compressed, out)
    end while before != out
    out
  end

  def self.process (orig, out)
    init = out.empty? ? true : false
    i, j = 0, 0
    while i < orig.size
      if orig[i] == "&"
        match = orig[i..-1][/^\&\d+-\d+/]
        x, y = match.split("-")
        x, y = x[1..-1].to_i, y.to_i
        if init
          out << "?" * (y - x + 1)
        else
          out[j, y - x + 1] = out[x..y]
        end
        i += match.size
        j += y - x + 1
      else
        out << orig[i] if init
        i += 1
        j += 1
      end
    end
    out
  end
end
