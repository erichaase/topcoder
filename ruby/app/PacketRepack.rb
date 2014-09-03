# PacketRepack[http://community.topcoder.com/stat?c=problem_statement&pm=7642]

class PacketRepack
  def self.solution (input, b, num_fields, field_size)
    bin = []
    input.each do |x|
      0.upto(b-1) do |y|
        bin << x[y]
      end
    end

    bout = []
    (num_fields - 1).downto(0) do |n|
      i = n * field_size
      bin[i, field_size].each do |x|
        bout << x
      end
    end

    out = []
    0.upto(input.size - 1) do |i|
      if bout[i * b]
        out << bout[i * b, b].reverse.collect { |x| x.to_s }.join().to_i(2)
      else
        out << 0
      end
    end

    out
  end
end
