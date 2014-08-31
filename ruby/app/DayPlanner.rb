# DayPlanner[http://community.topcoder.com/stat?c=problem_statement&pm=4637]

class DayPlanner
  def self.getEnds (tasks)
    tasks.collect! do |task|
      time, task   = task.split
      hour, minute = time.split(":").collect { |t| t.to_i }
      {
        'm' => hour * 60 + minute,
        't' => task
      }
    end

    tasks.sort! { |a, b| a['m'] <=> b['m'] }
    return "#{tasks[0]['t']}-#{tasks[-1]['t']}"
  end
end
