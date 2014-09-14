# ShipBoxes[http://community.topcoder.com/stat?c=problem_statement&pm=1212]

class ShipBoxes
  def self.solution (b1, b2)
    box1 = Box.new(b1[0], b1[1], b1[2])
    box2 = Box.new(b2[0], b2[1], b2[2])
    boxes = []

    box1.rotations.each do |b1|
      box2.rotations.each do |b2|
        [:xy, :xz, :yz].each do |axis|
          boxes << b1.add(axis, b2)
        end
      end
    end

    boxes.sort { |a, b| a.cost <=> b.cost }[0].cost
  end
end

class Box
  attr_accessor :x, :y, :z

  def initialize (x, y, z)
    @x, @y, @z = x, y, z
  end

  def rotations
    [
      Box.new(@x, @y, @z),
      Box.new(@x, @z, @y),
      Box.new(@z, @y, @x),
    ]
  end

  def add (axis, other)
    maxx = [@x, other.x].max
    maxy = [@y, other.y].max
    maxz = [@z, other.z].max

    sumx = @x + other.x
    sumy = @y + other.y
    sumz = @z + other.z

    case axis
    when :xy
      Box.new(maxx, maxy, sumz)
    when :xz
      Box.new(maxx, sumy, maxz)
    when :yz
      Box.new(sumx, maxy, maxz)
    end
  end

  def cost
    xy = 2 * @x * @y
    xz = 2 * @x * @z
    yz = 2 * @y * @z
    xy + xz + 2 * yz
  end
end
