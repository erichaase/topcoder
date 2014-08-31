# BalancedTrees[http://community.topcoder.com/stat?c=problem_statement&pm=1315]

class BalancedTrees
  def self.maxHeight (k, n)
    head = Node.new(k)
    (n-1).times { head.addNode }
    return head.height
  end
end

class Node
  attr_accessor :left, :right, :height

  def initialize (k=nil)
    @@k     = k if k
    @left   = nil
    @right  = nil
    @height = 1
  end

  def addNode
    hl = @left  ? @left.height  : 0
    hr = @right ? @right.height : 0

    if (hl + 1 - hr) <= @@k
      if @left
        @left.addNode
      else
        @left = Node.new
      end
      hl = @left.height
    else
      if @right
        @right.addNode
      else
        @right = Node.new
      end
      hr = @right.height
    end

    @height = [hl, hr].max + 1
  end
end
