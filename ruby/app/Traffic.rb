# Traffic[http://community.topcoder.com/stat?c=problem_statement&pm=586]

class Traffic
  def self.solution (lights, speed)
    states = Array.new(lights.size, true)
    timers = Array.new(lights)

    t = 0
    d = 0
    e = 0
    while true
      tick(lights, states, timers)

      e = d + speed
      if nextLight(d) == nextLight(e)
        d = e
      elsif states[nextLight(d)]
        d = e
      else
        d = (nextLight(d) + 1) * 150
      end

      break if d >= (lights.size + 1) * 150

      t += 1
    end

    t
  end

  def self.tick (lights, states, timers)
    timers.each_with_index do |v, i|
      if v == 0
        timers[i] = lights[i]
        states[i] = ! states[i]
      else
        timers[i] -= 1
      end
    end
  end

  def self.nextLight(d)
    (d-1) / 150
  end

end
