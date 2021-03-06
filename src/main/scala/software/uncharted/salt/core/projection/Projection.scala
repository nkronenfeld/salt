/*
 * Copyright 2015 Uncharted Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.uncharted.salt.core.projection

/**
 * A mapping from data-space to visualization-space (tile/bin coordinate)
 *
 * @tparam DC the abstract type representing a data-space coordinate
 * @tparam TC the abstract type representing a tile coordinate. Must feature a
 *            zero-arg constructor.
 * @tparam BC the abstract type representing a bin coordinate. Must feature a zero-arg
 *            constructor and should be something that can be represented in 1 dimension.
 */
abstract class Projection[DC, TC, BC]() extends Serializable {

  /**
   * Project a data-space coordinate into the corresponding tile coordinate and bin coordinate
   * @param dc the data-space coordinate
   * @param maxBin The maximum possible bin index (i.e. if your tile is 256x256, this would be (255,255))
   * @return Option[Seq[(TC, Int)]] representing a series of tile coordinate/bin index pairs if the given source
   *         row is within the bounds of the viz. None otherwise.
   */
  def project(dc: Option[DC], maxBin: BC): Option[Seq[(TC, BC)]]

  /**
   * Project a bin index BC into 1 dimension for easy storage of bin values in an array
   * @param bin A bin index
   * @param maxBin The maximum possible bin index (i.e. if your tile is 256x256, this would be (255,255))
   * @return the bin index converted into its one-dimensional representation
   */
  def binTo1D(bin: BC, maxBin: BC): Int
}
