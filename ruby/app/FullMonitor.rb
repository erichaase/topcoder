# FullMonitor[http://community.topcoder.com/stat?c=problem_statement&pm=1929]

class FullMonitor
  def self.solution (pixels)
    pixels.collect! { |p| p.split(",").collect { |i| i.to_i } }

    l = { xy: {}, yz: {}, xz: {} }

    pixels.each do |p|
      x, y, z = p[0], p[1], p[2]
      l[:xy][[x, y]] = true
      l[:yz][[y, z]] = true
      l[:xz][[x, z]] = true
    end

    l[:xy].each_key do |xy|
      l[:yz].each_key do |yz|
        l[:xz].each_key do |xz|
          if (xy[0] == xz[0]) && 
             (xy[1] == yz[0]) &&
             (yz[1] == xz[1])
            return -1 if not pixels.include? [xy[0], xy[1], yz[1]]
          end
        end
      end
    end

    l[:xy].size + l[:yz].size + l[:xz].size
  end
end
