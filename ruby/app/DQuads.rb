# DQuads[http://community.topcoder.com/stat?c=problem_statement&pm=1663]

class DQuads
  def self.solution (flights)
    f = flights.collect { |flight| flight.split.collect { |f| f.to_i } }

    quads = []
    f.each_index do |i|
      f[i].each_index do |j|
        a = f[i][j]
        f[a].each do |b|
          f[b].each do |c|
            f[c].each do |d|
              q = [i,a,b,c,d]
              next if i != d
              next if q.uniq.size != 4
              next if f[i].find_index(b)
              next if f[a].find_index(c)
              next if f[b].find_index(d)
              next if f[c].find_index(a)
              quads << q
            end
          end
        end
      end
    end

    quads.size / 4
  end
end
