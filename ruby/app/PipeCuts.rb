# PipeCuts[http://community.topcoder.com/stat?c=problem_statement&pm=3994]

class PipeCuts
  def self.solution (wl, l)
    cuts = {}
    wl.combination(2) do |w|
      c = [0, w[0], w[1], 100].sort
      cuts[c] = true
    end

    gcuts = []
    cuts.each_key do |c|
      c[0...-1].each_index do |i|
        if c[i+1] - c[i] > l
          gcuts << c
          break
        end
      end
    end

    gcuts.size.to_f / cuts.size.to_f
  end
end
