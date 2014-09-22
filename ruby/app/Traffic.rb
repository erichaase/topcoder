# Traffic[http://community.topcoder.com/stat?c=problem_statement&pm=586]

class Traffic
  def self.solution (lights, speed)
    states = Array.new(lights.size, true)
    timers = Array.new(lights)

    t = 0
    d = 0
    while true
      d = newDistance(d, states, speed)
      updateStates(states, timers, lights)
      t += 1
      break if d >= (lights.size + 1) * 150
    end

    t
  end

  def self.updateStates (states, timers, lights)
    timers.each_with_index do |v, i|
      if v == 1
        timers[i] = lights[i]
        states[i] = ! states[i]
      else
        timers[i] -= 1
      end
    end
  end

  def self.newDistance (d, states, speed)
    e = d + speed
    if nextLight(d) == nextLight(e)
      d = e
    elsif states[nextLight(d)]
      d = e
    else
      d = (nextLight(d) + 1) * 150
    end
  end

  def self.nextLight(d)
    (d-1) / 150
  end

end
