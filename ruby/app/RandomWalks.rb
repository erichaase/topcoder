class RandomWalks
  def self.solution (r)
    c     = [0, 0]
    path  = ""
    paths = {}

    begin
      r = (r * 25173 + 13849) % 65536

      case (r / 16384).to_i
      when 0
        d = [c[0], c[1] + 1]
        char = "U"
      when 1
        d = [c[0], c[1] - 1]
        char = "D"
      when 2
        d = [c[0] - 1, c[1]]
        char = "L"
      when 3
        d = [c[0] + 1, c[1]]
        char = "R"
      else
        raise "invalid r value: #{r}"
      end

      next if paths.has_key? ([c, d])
      paths[[c, d]] = true
      paths[[d, c]] = true

      path << char
      c = d

      return "" if path.size > 200000
    end while c != [0, 0]

    if path.size > 40
      path[0, 20] + "..." + path[-20, 20]
    else
      path
    end
  end
end
