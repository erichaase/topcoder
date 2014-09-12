# SearchDisks[http://community.topcoder.com/stat?c=problem_statement&pm=7525]

class SearchDisks
  def self.solution (diskNames, searchingDisk)
    n = 0
    diskNames.split.reverse.each do |diskname|
      if diskname == searchingDisk
        return n
      else
        n += 1
      end
    end
    return -1
  end
end
